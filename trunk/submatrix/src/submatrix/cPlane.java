/*
 *
 *     Copyright (C) 2010  David Fernandes
 *
 *                         Rua da Quinta Amarela, 60
 *                         4475-663 MAIA
 *                         PORTUGAL
 *
 *                         <daugfernandes@aim.com>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package submatrix;

/*

    submatrix::cPlane.java

 */
/**
 *
 * @author david
 */
public class cPlane {

    cPlace _places[][];

    /**
     *
     */
    public cPlane() {
        _places=new cPlace [32][32];
        for(int x=0;x<32;x++)
            for(int y=0;y<32;y++)
                _places[x][y]=new cPlace();
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public cPlace getPlace(int x, int y) {
        if(x<0||x>31||y<0||y>31)
            return null;
        else
            return _places[x][y];
    }

    /**
     *
     * @param p_value
     * @param x
     * @param y
     * @return
     */
    public boolean setPlace(cPlace p_value, int x, int y) {
        if(x<0||x>31||y<0||y>31)
            return false;
        else {
            _places[x][y] = p_value;
            return true;
        }
    }

}
