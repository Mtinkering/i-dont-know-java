package learning;


import java.util.Optional;

/*
* The advantage compared to null reference is it forces us to think about the case when the value is not present.
 */
public class Optional101 {

    public static void main(String[] args) {
//        Optional<Computer> computer = new Optional<>();
         Computer computer = new Computer();

        Optional<Computer> maybeComputer = Optional.of(computer);

        String name = maybeComputer.flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUSB)
                .map(USB::getVersion)
                .orElse("UNKNOWN");

        Soundcard soundcard = new Soundcard();
        Optional<Soundcard> maybeSoundcard = Optional.of(soundcard);

        Soundcard soundcard2 = maybeSoundcard.orElse(new Soundcard());

        USB usbx = new USB();
        Optional<USB> maybeUSB = Optional.of(usbx);

        maybeUSB.filter(usb -> "3.0".equals(usb.getVersion()));
//                .ifPresent(() -> System.out.println("ok"));

        // DO NOT DO THIS. isPresent + get
//        if(soundcard.isPresent()){
//            System.out.println(soundcard.get());
//        }
    }

    public static class Computer {
        private Optional<Soundcard> soundcard;

        public Optional<Soundcard> getSoundcard() {
            return soundcard;
        }
    }

    public static class Soundcard {
        private Optional<USB> usb;
        public Optional<USB> getUSB() {
           return usb;
        }
    }

    public static class USB {
        public String getVersion(){
            return "1";
        }
    }



}
//To study:
//Make sure you brush up on the Java SE 8 lambdas and method references syntax (see "Java 8: Lambdas") as well as its stream pipelining concepts (see "Processing Data with Java SE 8 Streams").
//