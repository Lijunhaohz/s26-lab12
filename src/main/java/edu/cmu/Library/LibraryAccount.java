package edu.cmu.Library;

public class LibraryAccount {
    private LibraryService libraryService;
 
    /**
     * Retrieves an array of checked out books associated with the specified user ID. If the user
     * has no books checked out, the returned list will be empty. Since multiple households may
     * share a single account, the user ID is of the form "libraryID:userName".
     * e.g., "12345:John Doe"
     *
     * @param userId the ID of the user whose books are to be retrieved
     * @return an array of Book objects the user has checked out
     * @throws IllegalArgumentException if userId is null or not in the correct format
     */
    public Book[] getBooks(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        
        String[] parts = userId.split(":", 2);
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            throw new IllegalArgumentException(
                "User ID must be in format 'libraryID:userName', got: " + userId);
        }
        
        String libraryId = parts[0];
        String userName = parts[1];
        return libraryService.getBooks(userName, libraryId);        
    }
}
