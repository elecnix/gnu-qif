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
 * Bank account transaction.
 * Does not support splits yet.
 *
 * @author <a href="mailto:nicolas@marchildon.net">Nicolas Marchildon</a>
 * @version $Id: BankTransaction.java,v 1.1 2001/11/17 07:29:07 nicolas Exp $
 */
public class BankTransaction extends QIFRecord {

    // Non-investment

    public static final String FIELD_DATE = "D";
    public static final String FIELD_TOTAL = "T";
    public static final String FIELD_CLEARED_STATUS = "C";
    public static final String FIELD_NUMBER = "N";
    public static final String FIELD_PAYEE = "P";
    public static final String FIELD_MEMO = "M";
    public static final String FIELD_ADDRESS = "A";
    public static final String FIELD_CATEGORY = "L";   // (Category/Subcategory/Transfer/Class)
    public static final String FIELD_MEMO_IN_SPLIT = "E";
    public static final String FIELD_AMOUNT_OF_SPLIT = "$";
    public static final String FIELD_END_OF_ENTRY = "^";

    // Investment

    public static final String FIELD_ACTION = "N";  // For investments
    public static final String FIELD_SECURITY = "Y";  // For investments
    public static final String FIELD_PRICE = "I";  // For investments
    public static final String FIELD_QUANTITY = "Q";  // For investments, number of shares or split ratio
    public static final String FIELD_TRANSACTION_AMOUNT = "T";  // For investments
    public static final String FIELD_COMMISSION = "O";  // For investments
    public static final String FIELD_ACCOUNT_FOR_TRANSFER = "L";   // For investments
    public static final String FIELD_AMOUNT_TRANSFERRED = "$";   // For investments

    
    /**
     * Constructs a blank TransactionRecord.
     */
    public BankTransaction() {
    }


    /*******/

    /**
     * The D tag denotes the date.
     */
    protected Date date = null;    

    /**
     * Sets the date of the transaction.
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * Returns the date of the transaction.
     */
    public Date getDate() {
        return this.date;
    }

    /*******/

    /**
     * The T field is the "Total" amount of the transaction.
     * If there are splits, the sum of all the split amounts
     * is in a T field.
     * Money going out of the account is negative.
     */
    protected float total = 0;

    /**
     * Sets the total amount of the transaction.
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /*******/

    /**
     * The N field is a "Number", which is usually a check number
     * or some other identifying number for the transaction.
     */
    protected String number = null;

    /**
     * Sets the transaction's number, which is usually a check number
     * or some other identifying number for the transaction.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Returns the transaction's number, which is usually a check number
     * or some other identifying number for the transaction.
     */
    public String getNumber() {
        return this.number;
    }

    /*******/

    /**
     * The C field represents the clearing/reconciliation state
     * of the transaction. An x or X in this field means the
     * transaction is "Cleared", a * means the transaction is
     * Reconciled.
     */
    protected boolean cleared = false;

    /**
     * Sets the "cleared" status.
     */
    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }
    
    /**
     * Returns whether the transaction is "cleared" or not.
     */
    public boolean isCleared() {
        return this.cleared;
    }

    /*******/

    /**
     * The C field represents the clearing/reconciliation state
     * of the transaction. An x or X in this field means the
     * transaction is "Cleared", a * means the transaction is
     * Reconciled.
     */
    protected boolean reconciled = false;

    /**
     * Sets the "reconciled" flag.
     */
    public void setReconciled(boolean reconciled) {
        this.reconciled = reconciled;
    }
    
    /**
     * Returns whether the transaction is "reconciled" or not.
     */
    public boolean isReconciled() {
        return this.reconciled;
    }

    /*******/

    /**
     * The M field is the transaction memo.
     */
    protected String memo = null;
    
    /**
     * Give the transaction a memo.
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * Returns the transaction's memo, or <code>null</code> if none was set.
     */
    public String getMemo() {
        return this.memo;
    }

    /*******/

    /**
     * The P field is the Payee.
     */
    protected String payee = null;

    /**
     * Sets who's involved in the transaction, such as the name of a
     * store where expenses took place.
     */    
    public void setPayee(String payee) {
        this.payee = payee;
    }
    
    /**
     * Returns who's involved in the transaction, such as the name of a
     * store where expenses took place.
     */
    public String getPayee() {
        return this.payee;
    }
    
    /*******/

    /**
     * The category from which the amount of the transaction
     * was taken from.
     */
    protected String category = null;
    
    /**
     * Sets the category from which the amount of the transaction
     * was taken from.
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    /*******/

    /**
     * The account from which the amount of the transaction
     * was taken from.
     */
    protected String account = null;

    /**
     * Sets the account from which the amount of the transaction
     * was taken from.
     */
    public void setAccount(String account) {
        this.account = account;
    }
    
    /**
     * Returns the account from which the amount of the transaction
     * was taken from.
     */
    public String getAccount() {
        return this.account;
    }
    
    /*******/

    /**
     * Returns the complete QIF record corresponding to the AccountRecord.
     * Values that were not explicitely set are not included in the
     * result.
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("!Type:" + TYPE_BANK + "\n");
        buffer.append(FIELD_DATE + encodeDate(date) + "\n");
        buffer.append(FIELD_TOTAL + total + "\n");
        if (number != null) {
            buffer.append(FIELD_NUMBER + number + "\n");
        }
        
        // Note: only one of these two should be set?
        if (reconciled) {
            buffer.append(FIELD_CLEARED_STATUS + "*\n");
        }
        if (cleared) {
            buffer.append(FIELD_CLEARED_STATUS + "X\n");
        }
        
        if (memo != null) {
            buffer.append(FIELD_MEMO + memo + "\n");
        }
        if (payee != null) {
            buffer.append(FIELD_PAYEE + payee + "\n");
        }
        
        if (category != null) {
            if (account != null) {
                buffer.append(FIELD_CATEGORY + account + ":" + category + "\n");
            } else {
                buffer.append(FIELD_CATEGORY + category + "\n");
            }
        } else {
            if (account != null) {
                buffer.append(FIELD_CATEGORY + "[" + account + "]\n");
            }
        }
        
        buffer.append(FIELD_END_OF_ENTRY + "\n");
        return buffer.toString();
    }

}
