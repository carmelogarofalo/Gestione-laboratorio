public class Tesista implements Runnable
{
    private int k;
    private Tutor tutor;
    public Tesista(int k, Tutor tutor)
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
                n = tutor.lock_computer("tesista",5);
                System.out.print("\nTesista preso il computer: "+n);
                Thread.sleep((long) (Math.random()*1000));
                tutor.unlock_computer("tesista",n);
                System.out.print("\nTesista finito con computer: "+n);
            } catch (InterruptedException e) {throw new RuntimeException(e);}
        }

    }
}
