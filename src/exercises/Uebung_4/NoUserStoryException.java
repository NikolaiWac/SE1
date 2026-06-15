package exercises.Uebung_4;


public class NoUserStoryException extends Exception {
        private static final long serialVersionUID = 1L;


        public String getMessage() {
            return "No User Story with this ID found";
        }
}
