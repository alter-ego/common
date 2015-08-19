package solutions.alterego.android.common.monads;

// Credits to https://dzone.com/articles/whats-wrong-java-8-part-iv
public abstract class Try<V> {

    private Try() {
    }

    public abstract Boolean isSuccess();

    public abstract Boolean isFailure();

    public abstract void throwException();

    public static <V> Try<V> failure(String message) {
        return new Failure<>(message);
    }

    public static <V> Try<V> failure(String message, Exception e) {
        return new Failure<>(message, e);
    }

    public static <V> Try<V> failure(Exception e) {
        return new Failure<>(e);
    }

    public static <V> Try<V> success(V value) {
        return new Success<>(value);
    }

    private static class Failure<V> extends Try<V> {

        private RuntimeException exception;

        public Failure(String message) {
            super();
            this.exception = new IllegalStateException(message);
        }

        public Failure(String message, Exception e) {
            super();
            this.exception = new IllegalStateException(message, e);
        }

        public Failure(Exception e) {
            super();
            this.exception = new IllegalStateException(e);
        }

        @Override
        public Boolean isSuccess() {
            return false;
        }

        @Override
        public Boolean isFailure() {
            return true;
        }

        @Override
        public void throwException() {
            throw this.exception;
        }
    }

    private static class Success<V> extends Try<V> {

        private V value;

        public Success(V value) {
            super();
            this.value = value;
        }

        @Override
        public Boolean isSuccess() {
            return true;
        }

        @Override
        public Boolean isFailure() {
            return false;
        }

        @Override
        public void throwException() {
        }
    }
}