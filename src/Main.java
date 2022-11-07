import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    static int numero_studenti;
    static int numero_tesisti;
    static int numero_professori;

    public static void main(String[] args) throws IOException
    {

        inserimento();

        int k = (int)(Math.random() *  5) + 1;
        int i;

        Boolean[] laboratorio = new Boolean[20];

        for(i=0; i<laboratorio.length; i++) laboratorio[i] = false;

        Tutor tutor = new Tutor(laboratorio);
        Studente studente = new Studente(k,tutor);
        Tesista tesista = new Tesista(k,tutor);
        Professore professore = new Professore(k,tutor);

        for(i=0; i<numero_studenti; i++)
        {
            Thread thread_studente = new Thread(studente);
            thread_studente.start();
        }

        for(i=0; i<numero_tesisti; i++)
        {
            Thread thread_tesista = new Thread(tesista);
            thread_tesista.start();
        }

        for(i=0; i<numero_professori; i++)
        {
            Thread thread_professore = new Thread(professore);
            thread_professore.start();
        }
    }

    private static void inserimento() throws IOException
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Inserisci il numero di studenti: ");
        numero_studenti = Integer.parseInt(bufferedReader.readLine());

        System.out.print("Inserisci il numero di tesisti: ");
        numero_tesisti = Integer.parseInt(bufferedReader.readLine());

        System.out.print("Inserisci il numero di professori: ");
        numero_professori = Integer.parseInt(bufferedReader.readLine());
    }

}
