package com.example.demo_azure_key_vault.mapper;

import com.example.demo_azure_key_vault.domain.User;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper {

    User Sel(int id);
}
