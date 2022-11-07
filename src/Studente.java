public class Studente implements Runnable
{
    private int k;
    private Tutor tutor;

    public Studente(int k, Tutor tutor)
    {
        this.k = k;
        this.tutor = tutor;
    }

    @Override
    public void run()
    {
        int n;

        for (int i=0; i<=k; i++)
        {
            try
            {
                n = tutor.lock_computer("studente",0);
                System.out.print("\nStudente preso il computer: "+n);
                Thread.sleep((long) (Math.random()*1000));
                tutor.unlock_computer("studente",n);
                System.out.print("\nStudente finito con computer: "+n);
            } catch (InterruptedException e) {throw new RuntimeException(e);}
        }

    }

}
