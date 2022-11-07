import java.util.Arrays;

public class Tutor
{
    private final Boolean[] laboratorio; //se il computer[i] e' occupato allora = true, altrimenti false
    public Tutor(Boolean[] laboratorio)
    {
        this.laboratorio = laboratorio;
    }

    public int lock_computer(String richiedente, int computer) throws InterruptedException
    {
        synchronized (laboratorio)
        {
            switch (richiedente)
            {
                case "studente":

                    while(true)
                    {
                        for(int i=0; i<laboratorio.length; i++)
                        {
                            if(!laboratorio[i])
                            {
                                laboratorio[i] = true;
                                return i;
                            }
                        }
                        laboratorio.wait();
                    }

                case "tesista":
                    while(laboratorio[computer])
                        laboratorio.wait();

                    laboratorio[computer] = true;

                    return computer;

                case "professore":

                    int conta,i;

                    while(true)
                    {
                        conta = 0;

                        for(i=0; i<laboratorio.length; i++)
                            if(!laboratorio[i]) conta++;


                        if(conta == 20)
                        {
                            for(i=0; i<laboratorio.length; i++)
                                laboratorio[i] = true;

                            return -1;
                        }

                        else laboratorio.wait();

                    }
            }
        }
        return 4;
    }

    public void unlock_computer(String richiedente, int computer)
    {
        synchronized (laboratorio)
        {
            if ("professore".equals(richiedente)) {
                Arrays.fill(laboratorio, false);
                laboratorio.notifyAll();
            } else {
                laboratorio[computer] = false;
                laboratorio.notifyAll();
            }
        }
    }
}