import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

    public static long timer(Runnable method, TimeUnit timeUnit) {
        long startTime = System.currentTimeMillis();
        method.run();
        long timeSpent = System.currentTimeMillis() - startTime;
        return TimeUnit.NANOSECONDS.convert(timeSpent, timeUnit);
    }

    public static void PrimeNumber(ArrayList<Integer> primeNumbers, int max){
        //sieves of eratosthenes
        byte[] isPrime=new byte[max+1];

        for (int i = 2; i <max+1; i++) {
            isPrime[i]=1;

        }
        primeNumbers.add(2);
        for (int i = 3; i<=max; i+=2) {//смотрим только нечетные
            if(isPrime[i]==1){
                primeNumbers.add(i);
                for (int j = i*i; j <=max && j>0 ; j+=i) {
                    isPrime[j]=0;
                }
            }

        }


        System.out.println("Last prime number:"+primeNumbers.get(primeNumbers.size()-1));
        System.out.println("All:"+primeNumbers.size());
    }
    public static void PrimeNumberSundarama(ArrayList<Integer> primeNumbers, int max){
        //sieve of sundaram
        byte[] isPrime=new byte[max+1];

        for (int i = 1; i <max+1; i++) {
            isPrime[i]=1;

        }

        for (int i = 1; 2*i*(i+1)<max; i++) {
            int ind=2*i*i +2*i;
            for (int j = i; ind <= max; j++) {

                isPrime[ind] = 0;
                ind = 2 * i*j + i + j;
            }
        }
        primeNumbers.add(2);
        for (int i = 1; i <=max ; i++) {
            if(isPrime[i]==1 && 2*i+1<=max){
                primeNumbers.add(2*i+1);

            }
        }





        System.out.println("Last prime number:"+primeNumbers.get(primeNumbers.size()-1));
        System.out.println("All:"+primeNumbers.size());
    }




    public static void main(String[] args) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        long time = timer(() -> PrimeNumber(primeNumbers, 50000),
                TimeUnit.NANOSECONDS);
        System.out.println("Time(nanosec):"+time);
        System.out.println("------------");
        ArrayList<Integer> primeNumbersS = new ArrayList<>();
        long timeS = timer(() -> PrimeNumberSundarama(primeNumbersS, 50000),
                TimeUnit.NANOSECONDS);
        System.out.println("Time(nanosec):"+timeS);


    }


}
