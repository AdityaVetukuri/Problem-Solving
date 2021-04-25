import javax.swing.JOptionPane;

public class Grading
{
    // Set array for Gnumbers and GPAs
    static String[] GNumbers = new String[4];
    static double[] GPAs = new double[4];

    public static void main(String[] args)
    {

        // call method to populate an array of GNumbers
        gnumArray(GNumbers);

        // call method to populate an array of GPAs
        gpaArray(GPAs);

        // call method to prompt user for GNumber
        String gNum = getGNumber();

        // call method to search and determine if GNumber matches student
        double gpa = searchGNum(gNum);

        // call method to describe the result
        describeResult(gpa);
    }

    // Prompting user for GNumbers
    public static void gnumArray(String[] GNumbers)
    {
        GNumbers[0] = "G00268451";
        GNumbers[1] = "G00759425";
        GNumbers[2] = "G00356112";
        GNumbers[3] = "G00558689";
    }

    // populating array with GPAs
    public static double[] gpaArray(double[] GPAs)
    {
        GPAs[0] = 2.73;
        GPAs[1] = 3.69;
        GPAs[2] = 3.82;
        GPAs[3] = 1.91;
        return GPAs;
    }

    // Get GNumber
    public static String getGNumber()
    {
        return JOptionPane.showInputDialog(null, "Enter student's GNumber: ");
    }

    // calling method to search and determine if the GNumber matches student
    public static double searchGNum(String gNum)
    {
        double gpa = 0.0;
        for (int i = 0; i < GNumbers.length; i++)
        {
            if (gNum.contentEquals(GNumbers[i]))
            {
                gpa = GPAs[i];
                break;
            }
        }
        return gpa;
    }

    // calling method to describe the result
    public static void describeResult(double gpa) {
        if (gpa != 0.0) {
            JOptionPane.showMessageDialog(null, "The student's GPA is: " + gpa);
        } else {
            JOptionPane.showMessageDialog(null, "Error! The GNumber entered is invalid.");
        }
    }
}