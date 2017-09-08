/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import service.GenericResponse;

/**
 *
 * @author Miss M
 */
public interface RowMapper {
    public GenericResponse mapRow(ResultSet rs) throws SQLException;
}
