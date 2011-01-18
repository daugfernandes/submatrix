

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

    ::cInstruction.java

 */
/**
 * Instrucção de script
 * @author david
 */
public class cInstruction {

    private int _order;
    private String _command;

    /**
     * constructor
     * @param p_order - ordem da instrucção no script
     * @param p_command - comando
     */
    public cInstruction(int p_order, String p_command) {
        _order=p_order;
        _command=p_command;
    }

    /**
     * Modificador
     * @param p_order - ordem da instrucção
     */
    public void setOrder(int p_order) {
        _order=p_order;
    }

    /**
     * Modificador
     * @param p_command - comando a executar
     */
    public void setCommand(String p_command) {
        _command=p_command;
    }

    /**
     * Selector
     * @return int com a ordem da instrucção
     */
    public int getOrder() {
        return _order;
    }

    /**
     * Selector
     * @return String com o comando
     */
    public String getCommand() {
        return _command;
    }

}
