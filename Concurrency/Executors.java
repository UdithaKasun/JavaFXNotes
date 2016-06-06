Executors

Executors are capable of running asynchronous tasks and typically manage a pool of threads, so we don't have to create new threads manually.

ExecutorService executor = Executors.newSingleThreadExecutor();
executor.submit(()->System.out.println("New Task");
