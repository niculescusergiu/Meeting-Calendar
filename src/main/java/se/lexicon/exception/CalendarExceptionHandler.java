package se.lexicon.exception;

import com.mysql.cj.exceptions.ExceptionInterceptor;
import se.lexicon.dao.implementation.DBConnectionException;
import se.lexicon.util.ConsoleColors;

import java.io.Console;

public class CalendarExceptionHandler {
    public static void handleException(Exception exception){
        if (exception instanceof AuthFailedException){
            System.out.println(ConsoleColors.YELLOW + exception.getMessage() + ConsoleColors.RESET);
        }else if (exception instanceof  UserExpiredException){
            System.out.println(ConsoleColors.RED + exception.getMessage() + ConsoleColors.RESET);
        }else if (exception instanceof DBConnectionException){
            System.out.println(ConsoleColors.YELLOW + exception.getMessage() + ConsoleColors.RESET);
        }else if (exception instanceof MySQLException){
            System.out.println(ConsoleColors.YELLOW + exception.getMessage() + ConsoleColors.RESET);
        }
    }
}
