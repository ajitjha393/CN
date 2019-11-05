# Creating a larger topology


set ns [new Simulator] 
set nf [open out.nam w]
$ns namtrace-all $nf

proc finish {} {

	global ns nf
	$ns flush-trace
	close $nf
	exec nam out.nam &
	exit 0

}

for {set i 0} {$i < 7} {incr i} {

	set n($i) [$ns node]
}

for {set i 0} {$i < 7} {incr i} {

	$ns duplex-link $n($i) $n([expr ($i+1)%7]) 1Mb 10ms DropTail
}

$ns at 5.0 "finish"

$ns run

