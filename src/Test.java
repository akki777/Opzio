public class Test {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String name = (String) Opzio.ofNullable(null).orElse("default");
        System.out.println(name);

        ApiResponse apiResponse1 = new ApiResponse();
        apiResponse1.result.data.firstName = "Akshay";
        Opzio.resolve(() -> apiResponse1.result.data.firstName)
                .ifPresent(firstName -> System.out.println(firstName))
                .ifAbsent(() -> System.out.println("Error handling"));


        ApiResponse apiResponse2 = new ApiResponse();
        apiResponse2.result.data.firstName = "mistake";
        Opzio.ofNullable(apiResponse2).map(v -> v.result).map(v -> v.data).map(v -> v.firstName)
                .filter(firstName -> firstName.equals("akshay"))
                .ifPresent(firstName -> System.out.println(firstName))
                .ifAbsent(() -> System.out.println("Error handling"));

        ApiResponse apiResponse3 = new ApiResponse();
        apiResponse3.result.data = null;
        Opzio.ofNullable(apiResponse3).map(v -> v.result).map(v -> v.data).map(v -> v.firstName)
                .ifPresent(firstName -> System.out.println(firstName))
                .ifAbsent(() -> System.out.println("Error handling"));
    }

}
