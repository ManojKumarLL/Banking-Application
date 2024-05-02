import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountValidationAndDetails {
    //account number details getting from Transaction Table
    public ResultSet getAccountDetails(int accNo, Connection connection){
        final String query = "select * from bank.transaction where accNo=?";
//        final String query = "select count(*)as count from bank.accountmaster where accNo = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
