package com.rainbowdoor.vmeet.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO Users (name, password, phone) VALUES (#{name}, #{password}, #{phone})")
    void insertUser(String name, String password, String phone);

    @Select("SELECT COUNT(*) FROM Users WHERE name = #{name} AND password = #{password}")
    int selectCountByNameAndPassword(String name, String password);

    @Update("UPDATE Users SET password = #{password} WHERE phone = #{phone}")
    void updatePasswordByPhone(String password, String phone);

    @Update("UPDATE Users SET phone = #{newPhone} WHERE phone = #{OldPhone}")
    void updatePhoneByPhone(String newPhone, String OldPhone);

    @Update("UPDATE Users SET name = #{newName} WHERE phone = #{phone}")
    void updateNameByPhone(String newName, String phone);
}
