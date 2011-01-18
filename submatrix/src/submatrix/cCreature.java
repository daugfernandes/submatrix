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

    submatrix::cCreature.java

 */
/**
 * Criatura
 * @author david
 */
public class cCreature {

    private String _name;
    private cRealm _realm_birth;
    private cRealm _actual_realm;
    private cPlace _place_birth;
    private String _image;

    /**
     * Constructor
     * @param p_name - nome da criatura
     * @param p_realmbirth - realm de nascimento
     * @param p_placebirth - lugar de nascimento
     * @param p_image - imagem associada
     */
    public cCreature(String p_name, cRealm p_realmbirth, cPlace p_placebirth, String p_image) {
        setName(p_name);
        setRealmBirth(p_realmbirth);
        setActualRealm(p_realmbirth);
        setPlaceBirth(p_placebirth);
        setImage(p_image);
    }

    /**
     * Modificador do nome da criatura apenas para uso da classe. Não se pode
     * modificar o nome de uma criatura sob pena de colidir com outras já
     * existentes.
     * @param p_name - nome a dar à criatura
     */
    private void setName(String p_name) {
        _name = p_name;
    }

    /**
     * Modificador do realm de nascimento da criatura.
     * @param p_realm
     */
    private void setRealmBirth(cRealm p_realm) {
        _realm_birth = p_realm;
    }

    /**
     * Modificador do realm actual da criatura.
     * @param p_realm
     */
    public void setActualRealm(cRealm p_realm) {
        _actual_realm = p_realm;
    }

    /**
     * Modificador do lugar de nascimento da criatura.
     * @param p_place - lugar de nascimento
     */
    private void setPlaceBirth(cPlace p_place) {
        _place_birth = p_place;
    }

    /**
     * Modificador da imagem da criatura.
     * @param p_image - string contendo o nome da imagem associada à criatura.
     */
    public void setImage(String p_image) {
        _image = p_image;
    }

    /**
     * Selector do nome da criatura
     * @return - String
     */
    public String getName() {
        return _name;
    }

    /**
     * Selector do realm de nascimento da criatura.
     * @return - cRealm
     */
    public cRealm getRealmBirth() {
        return _realm_birth;
    }

    /**
     * Selector do realm actual da criatura
     * @return cRealm
     */
    public cRealm getActualRealm() {
        return _actual_realm;
    }

    /**
     * Selector do lugar de nascimento da criatura
     * @return cPlace
     */
    public cPlace getPlaceBirth() {
        return _place_birth;
    }
    
    /**
     * Selector da imagem associada à criatura.
     * @return String
     */
    public String getImage() {
        return _image;
    }

    /**
     * ToString por default.
     * @return String
     */
    @Override public String toString() {
        return getName();
    }

}
