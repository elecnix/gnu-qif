/*
The gnu.qif package: A tool for creating QIF files.
Copyright (C) 2001  Nicolas Marchildon

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

package gnu.qif;

import java.util.Date;

/**
 * <p>The account header <code>!Account</code> is used in two places:
 * at the start of an account list and the start of a list of
 * transactions to specify to which account they belong.</p>
 *
 * @author <a href="mailto:nicolas@marchildon.net">Nicolas Marchildon</a>
 * @version $Id: AccountRecord.java,v 1.1 2001/11/17 07:29:07 nicolas Exp $
 */
public class AccountRecord extends QIFRecord {

    /** Name of the account */
    public static final String FIELD_NAME = "N";

    /** Type of account */
    public static final String FIELD_ACCOUNT_TYPE = "T";

    /** Description of the account */
    public static final String FIELD_DESCRIPTION = "D";
    
    /** Credit limit (only for credit card accounts) */
    public static final String FIELD_CREDIT_LIMIT = "L";

    /** Statement balance date */
    public static final String FIELD_STATEMENT_BALANCE_DATE = "/";

    /** Statement balance amount */
    public static final String FIELD_STATEMENT_BALANCE_AMOUNT = "$";

    
    /** Name of the account */
    protected String name = null;

    /** Name of the account */
    public void setName(String name) {
        this.name = name;
    }

    /** Name of the account */
    public String getName() {
        return this.name;
    }


    /** Type of account */
    protected String type = null;

    /** Type of account */
    public void setType(String type) {
        this.type = type;
    }

    /** Type of account */
    public String getType() {
        return this.type;
    }


    /** Description of the account */
    protected String description = null;
    
    /** Description of the account */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /** Description of the account */
    public String getDescription() {
        return this.description;
    }


    /** Credit limit (only for credit card accounts) */
    protected String creditLimit = null;

    /** Credit limit (only for credit card accounts) */
    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    /** Credit limit (only for credit card accounts) */
    public String getCreditLimit() {
        return this.creditLimit;
    }


    /** Statement balance date */
    protected String statementBalanceDate = null;

    /** Statement balance date */
    public void setStatementBalanceDate(String statementBalanceDate) {
        this.statementBalanceDate = statementBalanceDate;
    }
    
    /** Statement balance date */
    public String getStatementBalanceDate() {
        return this.statementBalanceDate;
    }


    /** Statement balance amount */
    protected String statementBalanceAmount = null;

    /** Statement balance amount */
    public void setStatementBalanceAmount(String statementBalanceAmount) {
        this.statementBalanceAmount = statementBalanceAmount;
    }
    
    /** Statement balance amount */
    public String getStatementBalanceAmount() {
        return this.statementBalanceAmount;
    }


    /**
     * Constructs an AccountRecord for defining an account of the
     * given name.
     */
    public AccountRecord(String name) {
        this.name = name;
    }

    /**
     * Returns the complete QIF record corresponding to the AccountRecord.
     * Values that were not explicitely set are not included in the
     * result.
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append(RECORD_START + RECORD_ACCOUNT + "\n");
        if (name != null) {
            buffer.append(FIELD_NAME + name + "\n");
        }
        if (type != null) {
            buffer.append(FIELD_ACCOUNT_TYPE + type + "\n");
        }
        if (description != null) {
            buffer.append(FIELD_DESCRIPTION + description + "\n");
        }
        if (creditLimit != null) {
            buffer.append(FIELD_CREDIT_LIMIT + creditLimit + "\n");
        }
        if (statementBalanceDate != null) {
            buffer.append(FIELD_STATEMENT_BALANCE_DATE + statementBalanceDate + "\n");
        }
        if (statementBalanceAmount != null) {
            buffer.append(FIELD_STATEMENT_BALANCE_AMOUNT + statementBalanceAmount + "\n");
        }
        buffer.append(RECORD_END + "\n");
        
        return buffer.toString();
    }

}
