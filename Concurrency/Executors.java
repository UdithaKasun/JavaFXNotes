[Executors]

# Executors are capable of running asynchronous tasks and typically manage a pool of threads, so we don't have 
  to create new threads manually.

  ExecutorService executor = Executors.newSingleThreadExecutor();
  executor.submit(()->System.out.println("New Task");
  
<-- Executor submit method overloads -->

  <T> Future<T> submit(Callable<T> task)
  Future<?> submit(Runnable task)
  <T> Future<T> submit(Runnable task, T result)
  
# Executors have to be stopped explicitly - otherwise they keep listening for new tasks.

<-- Executor Shutdown Methods -->

  shutdown() -> Waits for currently running tasks to finish.
  shutdownNow() -> Interrupts all running tasks and shut the executor down immediately.

# Best way to shutdown executor

try {
    System.out.println("attempt to shutdown executor");
    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.SECONDS);
}
catch (InterruptedException e) {
    System.err.println("tasks interrupted");
}
finally {
    if (!executor.isTerminated()) {
        System.err.println("cancel non-finished tasks");
    }
    executor.shutdownNow();
    System.out.println("shutdown finished");
}

* The executor shuts down softly by waiting a certain amount of time for termination of currently running tasks. 
* After a maximum of five seconds the executor finally shuts down by interrupting all running tasks.





