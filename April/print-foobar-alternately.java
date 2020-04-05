//Link of problem:  https://leetcode.com/problems/print-foobar-alternately/

class FooBar {
    private int n;
    private boolean isFoo = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        synchronized(this){
                    
            for (int i = 0; i < n; i++) {
                
                while (isFoo) {
                   try {
                      wait();
                   }
                   catch (InterruptedException e) {
                   }
                }
                
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFoo = true;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        synchronized(this){
                    
            for (int i = 0; i < n; i++) {
                
                while (!isFoo) {
                   try {
                      wait();
                   }
                   catch (InterruptedException e) {
                   }
                }
                
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printBar.run();
                isFoo = false;
                notify();
            }
        }
    }
}