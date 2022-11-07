public class Professore implements Runnable
{
    private int k;
    private Tutor tutor;

    public Professore(int k, Tutor tutor)
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
                n = tutor.lock_computer("professore",0);
                System.out.print("\nProfessore preso il laboratorio");
                Thread.sleep((long) (Math.random()*1000));
                tutor.unlock_computer("professore",n);
                System.out.print("\nProfessore finito con il laboratorio");
            } catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}
