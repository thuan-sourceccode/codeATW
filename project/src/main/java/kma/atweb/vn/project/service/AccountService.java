package kma.atweb.vn.project.service;

import kma.atweb.vn.project.dao.AccountDAO;
import kma.atweb.vn.project.entity.Account;
import kma.atweb.vn.project.form.AccountForm;
import kma.atweb.vn.project.mail.MessageChannel;
import kma.atweb.vn.project.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    // Đổi thông tin tài khoản
    public boolean changeInfo(String userName, Account newAccount) throws UsernameNotFoundException {
        Account account = accountDAO.findAccount(userName);

        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + userName + " was not found in the database");
        }

        return accountDAO.saveAccount(newAccount);
    }

    // Lấy thông tin tài khoản
    public Map<String, Object> getInfo(String userName) throws UsernameNotFoundException {
        Account account = accountDAO.findAccount(userName);

        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + userName + " was not found in the database");
        }

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("fullName", account.getFullName());
        userInfo.put("email", account.getEmail());
        userInfo.put("address", account.getAddress());
        userInfo.put("age", account.getAge());
        return userInfo;
    }

    // Khóa tài khoản
    public boolean lockAccount(String userName) throws UsernameNotFoundException {
        Account account = accountDAO.findAccount(userName);

        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + userName + " was not found in the database");
        }

        if(account.isActive()) {
            account.setActive(false);
            return accountDAO.saveAccount(account);
        }
        return true;
    }

    // Mở khóa tài khoản
    public boolean unlockAccount(String userName) throws UsernameNotFoundException {
        Account account = accountDAO.findAccount(userName);

        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + userName + " was not found in the database");
        }

        if(!account.isActive()) {
            account.setActive(true);
            return accountDAO.saveAccount(account);
        }
        return true;
    }

    public List<AccountForm> getAccounts() {
        return accountDAO.findAccounts("ROLE_EMPLOYEE");
    }
}
