import java.util.Scanner;
public class Performance {
    int[] mark = new int[60];
    int Mode, high, least;
        int[] freq = new int[10];
    int[] rep = new int[10];
    Performance() {
        Mode = high = least = -1;
 for (int i = 0; i < 10; i++) 
        {
  freq[i] = 0;
  rep[i] =0;
    }
    }

    void readMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the marks of 10 students");
        for (int i = 0; i < 10; i++)
        {
            mark[i] = scanner.nextInt();
            if(mark[i]> 100 || mark[i] <0)
            {
             System.out.println("Invalid input ..Please enter values between 0 and 100");
             break;
            }
        }
    }
 int highestMark() {
        high = mark[0];
        for (int i = 0; i < 10; i++) {
            if (high < mark[i]) {
                high = mark[i];
            }
        }
        return high;
    }

    int leastMark() {
        least = mark[0];
        for (int i = 0; i < 10; i++) {
            if (least > mark[i])
                least = mark[i];
        }

        return least;
    }



    int getMode() {
    int k = 0;
    int samp[] = new int[10];
 for(int i =0;i<10;i++)
 samp[i] =mark[i];

    for (int i = 0; i <= 9; i++)
    {
        for (int j = i + 1; j <= 9; j++) 
        {
            if (samp[i] == samp[j] && samp[i]!= -1)
            {
                rep[k] = samp[i];
                freq[k]++;
                samp[j] = -1;
            
            }
        }
        k++;
    }

    int maxFreq = freq[0];
    int modeIndex = 0;

    for (int i = 0; i < 10; i++) {
        if (freq[i] > maxFreq) {
            maxFreq = freq[i];
            modeIndex = i;
        }
    }

    if (maxFreq == 0) {
        return -1; // No mode found
    }

    Mode = rep[modeIndex];
    return Mode;
}

int getFreqAtMode() {
    int k = 0;
    if(Mode == -1)
     Mode=getMode();
    
    if (Mode == -1) {
        return -1; // No mode found
    }
    else
    {
        for (int i=0;i<10;i++)
        {
            if(Mode == mark[i])
            k++;
        }
            return k;
    }

}
    void display() {
        for (int i = 0; i < 10; i++)
            System.out.println(mark[i]);
    }

    public static void main(String args[]) {
        Performance p = new Performance();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
      
            System.out.println("1.Enter the marks:");
            System.out.println("2.Mode");
            System.out.println("3.Mode Frequency");
            System.out.println("4.Highest Mark");
            System.out.println("5.Least Mark");
            System.out.println("6.Display");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    p.readMarks();
                    break;
                case 2:
                    int S = p.getMode();
                    if(S == -1)
                    System.out.println("There is no Mode for this!!");
                    else
                    System.out.println("Mode: " + S);
                    break;
                case 3:
                     S = p.getFreqAtMode();
                    if(S == -1)
                    System.out.println("There is no Mode for this!!");
                    else
                    System.out.println("Freq of Mode:" + S);
                    break;
                case 4:
                    System.out.println("Highest Mark:" + p.highestMark());
                    break;
                case 5:
                    System.out.println("Least Mark:" + p.leastMark());
                    break;
                case 6:
                    p.display();
                    break;
                default:
                    System.out.println("Invalid option!!!");
                    break;
            }
        } while (choice != 6);
    }
}
