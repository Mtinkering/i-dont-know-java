package learning;


import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFuture101 {
    public static void main2(String[] args) throws InterruptedException, ExecutionException {
         Future<String> completableFuture = calculateAsync();
//        Future<String> completableFuture = CompletableFuture.completedFuture("Hello");


//        String result = completableFuture.get();
//        System.out.println(result);
//        System.out.println("Hi");
//
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
//
//        future.thenApply(s -> s + " World")
//                .thenAccept(s -> System.out.println(s))
//                .thenRun(() -> System.out.println("Hi"));
//
//        System.out.println(future.get());
//
//
//        // the thenCompose method to chain two Futures sequentially.
//        Why should a programmer use .thenCompose(x -> CompletableFuture.supplyAsync(() -> x+1)) instead of .thenApplyAsync(x -> x+1)?
        // It's not the programmer, but the library they use!
//        CompletableFuture<String> completableFuture3
//                = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
//
//        completableFuture3.get();
//
//        // 2 independent Futures
//        CompletableFuture<String> completableFuture4
//                = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCombine(CompletableFuture.supplyAsync(
//                        () -> " World"), (s1, s2) -> s1 + s2);
//
//        completableFuture4.get();

        // Do something with two Futures‘ results, but don’t need to pass any resulting value down a Future chain
//        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
//                        (s1, s2) -> System.out.println(s1 + s2));
//        future2.get();
//
//
//        String name = null;
//
//
//        CompletableFuture<String> completableFuturex
//                =  CompletableFuture.supplyAsync(() -> {
//            if (name == null) {
//                throw new RuntimeException("Computation error!");
//            }
//            return "Hello, " + name;
//        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
//
//        completableFuturex.get()    ;
//    assertEquals("Hello, Stranger!", );


        // The methods without the Async postfix run the next execution stage using a calling thread
        // With Async, it happens in another thread
    }

    public static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(5000);

            // When the computation is done, the method completes the Future by providing the result to the complete method:
            completableFuture.complete("Hello");
            System.out.println("Hi");
            return null;
        });

        return completableFuture;
    }


    public static void main(String... args) throws ExecutionException, InterruptedException {
        System.out.println("main thread: " + Thread.currentThread().getName());

        CompletableFuture<String> user = CompletableFuture.supplyAsync(() -> getUser());


        CompletableFuture<Integer> future1 = user.thenApplyAsync(a -> convertToB(a));

        CompletableFuture<Integer> future2 = user.thenApplyAsync(a -> convertToC(a));

//        CompletableFuture<Integer> future1 = CompletableFuture

//                .supplyAsync(() -> doSomethingAndReturnA())
////                .thenCompose(a -> CompletableFuture.supplyAsync(() -> {
////                    System.out.println("another thead: " + Thread.currentThread().getName());
////                    return 1;
////                }));
//                .thenApplyAsync(a -> convertToB(a));
//
//        CompletableFuture<Integer> future2 = CompletableFuture
//                .supplyAsync(() -> doSomethingAndReturnA())
////                .thenCompose(a -> CompletableFuture.supplyAsync(() -> {
////                    System.out.println("another thead: " + Thread.currentThread().getName());
////                    return 1;
////                }));
//                .thenApplyAsync(a -> convertToB(a));

        future1
                .thenCombine(future2,  (s1, s2) -> {
                    System.out.println("combine: " + Thread.currentThread().getName());
                    return s1 + s2;
                })
                .thenAccept(System.out::println);
//        future.get();

//        CompletableFuture
//                .supplyAsync(() -> {
//                    String a = doSomethingAndReturnA();
//                    convertToB(a);
//                    return 'x';
//                });
//                System.out.println("main: " + Thread.currentThread().getName());
//

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int convertToB(final String a) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("convertToB: " + Thread.currentThread().getName());
        return Integer.parseInt(a);
    }
    private static int convertToC(final String a) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("convertToC: " + Thread.currentThread().getName());
        return Integer.parseInt(a);
    }



    private static String getUser() {
        System.out.println("Get User here: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "1";
    }
    private static String doSomethingAndReturnA() {
        System.out.println("doSomethingAndReturnA here: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "1";
    }

    // Supply
}

