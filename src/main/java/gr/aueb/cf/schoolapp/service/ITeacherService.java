package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
import gr.aueb.cf.schoolapp.exceptions.TeacherAlreadyExistsException;
import gr.aueb.cf.schoolapp.exceptions.TeacherNotFoundException;

import java.util.List;

public interface ITeacherService {

    TeacherReadOnlyDTO insertTeacher(TeacherInsertDTO dto)
        throws TeacherDAOException, TeacherAlreadyExistsException;

    TeacherReadOnlyDTO updateTeacher(Integer id, TeacherUpdateDTO dto)
        throws TeacherDAOException, TeacherAlreadyExistsException, TeacherNotFoundException;

    void deleteTeacher(Integer id) throws TeacherDAOException, TeacherNotFoundException;

    TeacherReadOnlyDTO getTeacherById(Integer id) throws
            TeacherDAOException, TeacherNotFoundException;

    List<TeacherReadOnlyDTO> getAllTeachers() throws TeacherDAOException;

    List<TeacherReadOnlyDTO> getTeachersByLastname(String lastname) throws TeacherDAOException;
}
