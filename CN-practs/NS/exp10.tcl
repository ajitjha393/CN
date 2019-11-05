# CBR TRAFFIC


set ns [new Simulator] 

$ns color 1 Blue
$ns color 2 Red

set nf [open out.nam w]
$ns namtrace-all $nf

proc finish {} {

	global ns nf
	$ns flush-trace
	close $nf
	exec nam out.nam &
	exit 0

}


set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]


$ns duplex-link $n0 $n2 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns duplex-link $n2 $n3 1Mb 10ms DropTail


$ns duplex-link-op $n0 $n2 orient right-down
$ns duplex-link-op $n1 $n2 orient right-up
$ns duplex-link-op $n2 $n3 orient right



# Create a udp agent and attach it to node n0
set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0
$udp0 set class_1


set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_500
$cbr0 set interval_0.005
$cbr0 attach-agent $udp0

# Create udp agent and attach tp node n1

set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1
$udp1 set class_2


set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_500
$cbr1 set interval_0.005
$cbr1 attach-agent $udp1


set null0 [new Agent/Null]

$ns attach-agent $n3 $null0
$ns connect $udp0 $null0
$ns connect $udp1 $null0 



$ns at 0.5 "$cbr0 start"
$ns at 1.0 "$cbr1 start"
$ns at 4.0 "$cbr1 stop"
$ns at 4.5 "$cbr0 stop"



$ns at 5.0 "finish"

$ns run