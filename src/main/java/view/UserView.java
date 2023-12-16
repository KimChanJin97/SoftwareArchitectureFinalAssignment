package view;

import exception.UserNameException;
import exception.UserRoleException;
import java.util.Scanner;
import model.user.User;
import model.user.UserRole;

public class UserView {

    private final Scanner sc = new Scanner(System.in);

    public void askForAction() {
        System.out.println("\n스터디카페 시스템입니다\n[1] 로그인\n[2] 회원가입\n[3] 종료");
    }

    public void loginComment() {
        System.out.println("\n로그인을 진행합니다.");
    }

    public void registerComment() {
        System.out.println("\n회원가입을 진행합니다.");
    }

    public void registerSuccessComment(User user) {
        System.out.println("\n" + user.getName() + "님 회원가입을 축하합니다.");
    }

    public void askForName() {
        System.out.print("\n이름을 입력해주세요: ");
    }

    public void askForRole() {
        System.out.println("\n역할을 선택해주세요\n[1] 스터디카페 관리자\n[2] 스터디카페 손님");
    }

    public int inputAction() {
        try {
            String userInput = sc.nextLine();
            validateInputNumeric(userInput);
            return Integer.parseInt(userInput);
        } catch (UserRoleException e) {
            System.out.println(e.getMessage());
            return inputAction();
        }
    }

    public void printUserInfo(User user) {
        System.out.print(user.getName() + "님 ");
        if (user.isAdmin()) {
            System.out.println("\n관리자로 로그인하셨습니다.\n");
        } else {
            System.out.println("\n손님으로 로그인하셨습니다.\n");
        }
    }

    public String inputName() {
        try {
            String userName = sc.nextLine();
            validateUserName(userName);
            return userName;
        } catch (UserNameException e) {
            System.out.println(e.getMessage());
            return inputName();
        }
    }

    public UserRole inputRole() {
        try {
            String userInput = sc.nextLine();
            validateUserRole(userInput);
            int roleNumber = Integer.parseInt(userInput);
            return UserRole.of(roleNumber);
        } catch (UserRoleException e) {
            System.out.println(e.getMessage());
            return inputRole();
        }
    }

    public void validateUserRole(String userInput) {
        validateInputNumeric(userInput);
    }

    public void validateInputNumeric(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new UserRoleException("\n숫자만 입력 가능합니다.");
        }
    }

    public void validateUserName(String userName) {
        validateExist(userName);
    }

    public void validateExist(String userName) {
        if (userName.isEmpty()) {
            throw new UserNameException("\n이름은 공백일 수 없습니다");
        }
    }
}
