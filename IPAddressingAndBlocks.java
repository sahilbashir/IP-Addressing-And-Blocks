import java.awt.event.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.*;
import java.lang.*;
class text extends JFrame implements ActionListener {
// JTextField
static JTextField t,t1;
// JFrame
static JFrame f;
// JButton
static JButton b;
// label to display text
static JLabel l,l1,l2,l3,l4, l5, l6, l7;
// default constructor
text()
{
}
//calculate number of addresses in a block
public static int getNumberofAddress(String msk)
{
    StringTokenizer t1 = new StringTokenizer(msk, ".");
    int m1 = Integer.parseInt(t1.nextToken());
    int m2 = Integer.parseInt(t1.nextToken());
    int m3 = Integer.parseInt(t1.nextToken());
    int m4 = Integer.parseInt(t1.nextToken());
    System.out.println("M4 is "+m4);
    int[] nm1=toBinary(m1);
    int[] nm2=toBinary(m2);
    int[] nm3=toBinary(m3);
    int[] nm4=toBinary(m4);
    int prefix=0;
    int[][] arr=new int[4][8];
    arr[0]=nm1;
    arr[1]=nm2;
    arr[2]=nm3;
    arr[3]=nm4;
    for(int i=0;i<4;i++)
    {
    for(int j=0;j<8;j++)
    {
    if(arr[i][j]==1)
    {
        System.out.print(arr[i][j]);
    prefix++;
    }
    }
    System.out.println();
    }
    int NOA=(int)Math.pow(2,(32-prefix));
    System.out.println(NOA + " " + prefix);
    return NOA;
    }
    //check the validity of the ip addresses
    public static boolean validateIpAddress(String ipAddress) {
    boolean b1 = false;
    int ctr=0;
    for(int i=0;i<ipAddress.length();i++)
    {
    if((ipAddress.charAt(i)=='.'))
    {
        ctr++;
        }
        }
        if(ctr!=3)
        {
        System.out.println("Entered here");
        return b1;
        }
        StringTokenizer t = new StringTokenizer(ipAddress, ".");
        int a = Integer.parseInt(t.nextToken());
        int b = Integer.parseInt(t.nextToken());
        int c = Integer.parseInt(t.nextToken());
        int d = Integer.parseInt(t.nextToken());
        if ((a >= 0 && a <= 255) && (b >= 0 && b <= 255) && (c >= 0 && c <= 255) && (d >= 0 && d <=
        255))
        {
        b1 = true;
        }
        return b1;
        }
        //get the first address in the block of code of the given ip address
        public static String getFirstAddress(String ipAddress, String mask)
{
StringTokenizer t = new StringTokenizer(ipAddress, ".");
int i1 = Integer.parseInt(t.nextToken());
int i2 = Integer.parseInt(t.nextToken());
int i3 = Integer.parseInt(t.nextToken());
int i4 = Integer.parseInt(t.nextToken());
StringTokenizer t1 = new StringTokenizer(mask, ".");
int m1 = Integer.parseInt(t1.nextToken());
int m2 = Integer.parseInt(t1.nextToken());
int m3 = Integer.parseInt(t1.nextToken());
int m4 = Integer.parseInt(t1.nextToken());
int[] fai1=toBinary(i1);
int[] fam1=toBinary(m1);
int FA1=andIpandMask(fai1,fam1);
int[] fai2=toBinary(i2);
int[] fam2=toBinary(m2);
int FA2=andIpandMask(fai2,fam2);
int[] fai3=toBinary(i3);
int[] fam3=toBinary(m3);
int FA3=andIpandMask(fai3,fam3);
int[] fai4=toBinary(i4);
int[] fam4=toBinary(m4);
int FA4=andIpandMask(fai4,fam4);
String str=FA1+"."+FA2+"."+FA3+"."+FA4;
return str;
}
//get last address of the block of given ip address
public static String getLastAddress(String ipAddress, String mask)
{
StringTokenizer t = new StringTokenizer(ipAddress, ".");
int i1 = Integer.parseInt(t.nextToken());
int i2 = Integer.parseInt(t.nextToken());
int i3 = Integer.parseInt(t.nextToken());
int i4 = Integer.parseInt(t.nextToken());
StringTokenizer t1 = new StringTokenizer(mask, ".");
int m1 = Integer.parseInt(t1.nextToken());
int m2 = Integer.parseInt(t1.nextToken());
int m3 = Integer.parseInt(t1.nextToken());
int m4 = Integer.parseInt(t1.nextToken());
int[] fai1=toBinary(i1);
int[] fam1=toBinary(m1);
int FA1=orIpandMask(fai1,fam1);
int[] fai2=toBinary(i2);
int[] fam2=toBinary(m2);
int FA2=orIpandMask(fai2,fam2);
int[] fai3=toBinary(i3);
int[] fam3=toBinary(m3);
int FA3=orIpandMask(fai3,fam3);
int[] fai4=toBinary(i4);
int[] fam4=toBinary(m4);
int FA4=orIpandMask(fai4,fam4);
String str=FA1+"."+FA2+"."+FA3+"."+FA4;
return str;
}
//generate a random number
public int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
}
//return a block of address with the same size as that of the given ip address. Return network
//address and range of the block
public String getRandomAB(String mask)
{
int a=getRandomNumber(0,255);
int b=getRandomNumber(0,255);
int c=getRandomNumber(0,255);
int d=getRandomNumber(0,255);
String str=a+"."+b+"."+c+"."+d;
String fa = getFirstAddress(str, mask);
String la = getLastAddress(str, mask);
String output = "Block" + fa + " to " + la + "\n" + "Network address:"+fa;
return output;
}
// convert from decimal to binary
public static int[] toBinary(int decimal){
int binary[] = new int[40];
int index = 0;
while(decimal > 0){
binary[index++] = decimal%2;
decimal = decimal/2;
}
return binary;
}
//do binary IP and mask and return
public static int andIpandMask(int[] a,int[] b)
{
int n;
int sum=0,k;
int[] c=new int[8];
for(int i=0;i<8;i++)
{
c[i]=a[i]&b[i];
n=i;
k=(int)Math.pow(2,n);
sum=sum+(k*c[i]);
}
return sum;
}
//do binary or ip and mask and return
public static int orIpandMask(int[] a,int[] b)
{
int n;
int sum=0,k;
int vr;
int[] c=new int[8];
for(int i=0;i<8;i++)
{
if(b[i]==0)
{
vr=1;
}
else
{
vr=0;
}
c[i]=a[i]|vr;
n=i;
k=(int)Math.pow(2,n);
sum=sum+(k*c[i]);
}
return sum;
}
// main class
public static void main(String[] args)
{
// create a new frame to store text field and button
f = new JFrame("textfield");
// create a label to display text
l = new JLabel("nothing entered");
l1 = new JLabel("nothing entered");
l2 = new JLabel("nothing entered");
l3 = new JLabel("nothing entered");
l4= new JLabel("nothing entered");
l5 = new JLabel("nothing entered");
l6 = new JLabel("nothing entered");
l7= new JLabel("nothing entered");
// create a new button
b = new JButton("CHECK IP");
// create a object of the text class
text te = new text();
// addActionListener to button
b.addActionListener(te);
// create a object of JTextField with 16 columns and a given initial text
t = new JTextField("enter the ip address", 16);
t1 = new JTextField("enter the mask", 16);
// create a panel to add buttons and textfield
JPanel p = new JPanel();
// add buttons and textfield to panel
p.add(t);
p.add(l);
p.add(t1);
p.add(l1);
p.add(l2);
p.add(l3);
p.add(l4);
p.add(l5);
p.add(l6);
p.add(l7);
p.add(b);
// add panel to frame
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// set the size of frame
f.setSize(300, 300);
f.getContentPane().add(p);
f.show();
}
// if the button is pressed
public void actionPerformed(ActionEvent e)
{
String s = e.getActionCommand();
if (s.equals("CHECK IP")) {
// set the text of the label to the text of the field
// l.setText(t.getText());
String ipAddress=t.getText();
String mask=t1.getText();
boolean b = validateIpAddress(ipAddress);
System.out.println(b);
if (b)
{
l.setText("Valid IP");
}
else
{
l.setText("Invalid ip”);
}
boolean b1= validateIpAddress(mask);
if (b1)
{
l1.setText("Valid mask");
}
else if(!b1)
{l1.setText("Invalid mask");
}
// set the text of field to blank
l2.setText("First address is : "+getFirstAddress(ipAddress,mask));
l3.setText("Last address is : "+getLastAddress(ipAddress,mask);
l4.setText("Numer of addresses are : "+getNumberofAddress(mask));
l5.setText(getRandomAB(mask));
l6.setText(getRandomAB(mask));
l7.setText(getRandomAB(mask));
}
}
}
