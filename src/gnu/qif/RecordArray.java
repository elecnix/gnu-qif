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

import java.util.ArrayList;

/**
 * A bundle of records, without any restrictions on their type and order.
 *
 * @author <a href="mailto:nicolas@marchildon.net">Nicolas Marchildon</a>
 * @version $Id: RecordArray.java,v 1.1 2001/11/17 07:29:07 nicolas Exp $
 */
public class RecordArray {

    private ArrayList list = new ArrayList();
    
    public void addRecord(QIFRecord record) {
        list.add(record);
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            QIFRecord record = (QIFRecord) list.get(i);
            buffer.append("\n");
            buffer.append(record.toString());
        }
        return buffer.toString();
    }

}
