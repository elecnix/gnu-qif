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

import gnu.qif.RecordArray;
import gnu.qif.AccountRecord;
import gnu.qif.BankTransaction;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

import java.util.Date;

/**
 * <p>A concrete usage of the gnu.qif package, where two transactions
 * are recorded: an income and an expense.
 *
 * <p>You can run this sample by first setting your CLASSPATH
 * so that it included the gnu.qif classes (maybe the jar file),
 * by compiling it ("javac Sample3.java"), and running it ("java Sample3").</p>
 *
 * @see gnu.qif
 *
 * @author <a href="mailto:nicolas@marchildon.net">Nicolas Marchildon</a>
 * @version $Id: Sample3.java,v 1.1 2001/11/17 07:42:49 nicolas Exp $
 */
public class Sample3 {

    public static void main(String[] args) throws Exception {

        RecordArray myBankAccountRecords = new RecordArray();
        AccountRecord bankAccountHeader = new AccountRecord("My bank account");
        myBankAccountRecords.addRecord(bankAccountHeader);

        /* Record the deposit of the first paycheck */
        BankTransaction tr1 = new BankTransaction();
        tr1.setNumber("1");
        tr1.setTotal(100); // Deposit if positive, withdrawal when negative
        tr1.setDate(new Date());
        tr1.setPayee("My first paycheck");
        tr1.setCategory("My incomes");
        myBankAccountRecords.addRecord(tr1);

        /* Record the first expense */
        BankTransaction tr2 = new BankTransaction();
        tr2.setNumber("2");
        tr2.setTotal(-10); // Deposit if positive, withdrawal when negative
        tr2.setDate(new Date());
        tr2.setPayee("My first expense");
        tr2.setCategory("My expenses");
        myBankAccountRecords.addRecord(tr2);

        System.out.println(myBankAccountRecords.toString());
    }
    
}
