import java.io.*;

public class IPHeader {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Please enter the Hex Dump:");
String input = br.readLine();
String IPVer = input.substring(0,1);
if(IPVer.equals("4"))
System.out.println("IP Version: 4");
if(IPVer.equals("6"))
System.out.println("IP Version: 6");
String h_len = input.substring(1,2);
System.out.println("Header Length: " + (4 * Integer.parseInt(h_len,16)));
String s_type = input.substring(2,4);
String s_t_bin = Integer.toBinaryString(Integer.parseInt(s_type,16));
while(s_t_bin.length() < 8)
s_t_bin = "0" + s_t_bin;
System.out.println("Service Type: " + Integer.parseInt(s_t_bin.substring(0,3),2));
if(s_t_bin.charAt(3) == '1')
System.out.println("Minimize Delay Requested");
if(s_t_bin.charAt(4) == '1')
System.out.println("Maximize Throughput Requested");
if(s_t_bin.charAt(5) == '1')
System.out.println("Maximize Reliability Requested");
if(s_t_bin.charAt(6) == '1')
System.out.println("Minimize Cost Requested");
String tot_len = input.substring(4,8);
System.out.println("Total Length: " + Integer.parseInt(tot_len,16) + " Bytes");
String id = input.substring(8,12);
System.out.println("Identification: " + Integer.parseInt(id,16));
String frag = input.substring(12,16);
String frag_bin = Integer.toBinaryString(Integer.parseInt(frag,16));
while(frag_bin.length() < 16)
frag_bin = "0" + frag_bin;

String frag_flags = frag_bin.substring(0,3);
if(frag_flags.charAt(1) == '1')
System.out.println("Do not Fragment Packet");
else
System.out.println("Can be Fragmented");
if(frag_flags.charAt(2) == '1')
System.out.println("More Fragments pending");
else
System.out.println("No more Fragments pending");

System.out.println("Fragmentation Offset: " + ((8 * Integer.parseInt(frag_bin.substring(3, 16),2)) - (4 *
Integer.parseInt(h_len,16))));
String ttl = input.substring(16,18);
System.out.println("Time to live: " + Integer.parseInt(ttl,16) + " Hops");
String protocol = input.substring(18,20);
System.out.print("Protocol: ");
if(Integer.parseInt(protocol,16) == 1)
System.out.println("ICMP");
if(Integer.parseInt(protocol,16) == 2)
System.out.println("IGMP");
if(Integer.parseInt(protocol,16) == 89)
System.out.println("OSPF");
if(Integer.parseInt(protocol,16) == 6)
System.out.println("TCP");
if(Integer.parseInt(protocol,16) == 17)
System.out.println("UDP");
String checksum = input.substring(20,24);
System.out.println("Header Checksum: " + Integer.parseInt(checksum,16));
String s_ip = input.substring(24,32);
String s_ip_bin = Long.toBinaryString(Long.parseLong(s_ip,16));
while(s_ip_bin.length() < 32)
s_ip_bin = "0" + s_ip_bin;
System.out.print("Source IP Address: ");
System.out.print(Integer.parseInt(s_ip_bin.substring(0,8),2) + ".");
System.out.print(Integer.parseInt(s_ip_bin.substring(8,16),2) + ".");
System.out.print(Integer.parseInt(s_ip_bin.substring(16,24),2) + ".");
System.out.println(Integer.parseInt(s_ip_bin.substring(24,32),2));
String d_ip = input.substring(32,40);
String d_ip_bin = Long.toBinaryString(Long.parseLong(d_ip,16));
while(d_ip_bin.length() < 32)
d_ip_bin = "0" + d_ip_bin;
System.out.print("Destination IP Address: ");
System.out.print(Integer.parseInt(d_ip_bin.substring(0,8),2) + ".");
System.out.print(Integer.parseInt(d_ip_bin.substring(8,16),2) + ".");
System.out.print(Integer.parseInt(d_ip_bin.substring(16,24),2) + ".");
System.out.println(Integer.parseInt(d_ip_bin.substring(24,32),2));