package gnu.qif;

import java.util.Date;

/**
 * <p>If the very first Bank transaction in the file has a payee of
 * "Opening Balance", the L line contains the name of the account
 * that the file describes. Here is an example:</p>
 *
 * <pre>
 * !Type:Bank
 * D12/03/95
 * T4,706.57
 * CX
 * POpening Balance
 * L[New Bank]
 * ^
 * </pre>
 *
 * @author <a href="mailto:nicolas@marchildon.net">Nicolas Marchildon</a>
 * @version $Id: OpeningBalanceRecord.java,v 1.1 2001/11/17 07:29:07 nicolas Exp $
 */
public class OpeningBalanceRecord extends QIFRecord {

    protected String accountName = null;
    protected Date date = null;
    protected float balance = 0;

    public OpeningBalanceRecord(String accountName, Date date, float balance) {
        this.accountName = accountName;
        this.date = date;
        this.balance = balance;
    }

    /**
     * Returns the complete QIF record corresponding to the AccountRecord.
     * Values that were not explicitely set are not included in the
     * result.
     */
    public String toString() {
        if (accountName == null) {
            throw new IllegalStateException("Missing name of account of OpeningBalanceRecord");
        }
        if (date == null) {
            throw new IllegalStateException("Missing date of OpeningBalanceRecord");
        }
        
        StringBuffer buffer = new StringBuffer();
        buffer.append("!Type:" + TYPE_BANK + "\n");
        if (date != null) {
            buffer.append("D" + encodeDate(date) + "\n");
        }
        buffer.append("T" + balance + "\n");
        buffer.append("CX\n");
        buffer.append("POpeningBalance\n");
        buffer.append("L[" + accountName + "]\n");
        buffer.append("^\n");
        return buffer.toString();
    }

}
