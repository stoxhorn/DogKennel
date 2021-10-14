/*
 * FORMÅL:
 * At omskrive en procesorienteret løsning til en objektorienteret løsning
 *
 * OPGAVE:
 * Du skal forbedre denne kode ved at flytte de forskellige metoder
 * ud i klasser
 *
 * Fremgangsmåden er flg:
 * 1) Kør koden så du forstår hvad den gør
*  2) kopier eksisterende kode
 * 2) gem hver metode i en klasse med passende navne
   doDiag i en klasse der hedder 'Dialog'
   doVat i en klasse der hedder 'CalculateVat'
   doView i en klasse der hdder 'View'
   runController i en klasse der hedder Controller
 * 3) sørg for passende "inventar" (fields, constructor og metoder)

 * 4) sørg for at lave en Main som kun rummer flg:
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.runController();
    }
    *
    * TEST kørsel:
    * Indtast varens pris:
345,6
Du betaler 86,40 Kr i MOMS

*  5) Dokumenter programmet med et klassediagram - brug PlantUML
 *
 */



import java.util.Scanner;
public class ComputeVAT {
  

  public static void main(String[] args){
    Controller ctrl = new Controller();
    ctrl.runController();

  }
}
class Diag{
  
  private double number;

  public Diag(){
    Scanner myScan = new Scanner(System.in);
    System.out.println("Indtast varens pris: ");
    this.number = myScan.nextDouble();
    myScan.close();
  }

  public double getNumber(){
    return this.number;
  }

}

class View{
  
  final static String CURRENCY = "Kr";
  private double result;
  private String typeOfResult;
  public View(double result, String typeOfResult){
    this.result = result;
    this.typeOfResult = typeOfResult;
  }

  public double getResult(){
    return this.result;
  }

  public String getTypeOfResult(){
    return this.typeOfResult;
  }

  public String toString(){
    return String.format("Du betaler %.2f%3s i %s%n",result,CURRENCY,this.typeOfResult);
  }

}

class VAT{
  final static int PRCVAT = 25;
  
  private double number;
  private double VAT;

  public VAT(double number){
    this.number = number;
    this.VAT = number / 100 * PRCVAT; 
  }

  public double getNumber(){
    return this.number;
  }
  
  public double getVAT(){
    return this.VAT;
  }

}

class Controller{
  
  

  final static String MSG = "MOMS";  
  private VAT moms;
  private Diag diag;
  private View vw;
  private String ViewString;

  public Controller(){
    this.diag = new Diag();

    // calculates the VAT
    this.moms = new VAT(diag.getNumber());
  
    // prints out the data
    this.vw = new View(moms.getVAT(),MSG);
    this.ViewString = vw.toString();
  }
  
  public String runController(){
    return this.ViewString;
  }
  
}
