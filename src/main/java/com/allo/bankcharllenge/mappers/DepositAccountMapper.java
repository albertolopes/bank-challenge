package com.allo.bankcharllenge.mappers;

import com.allo.bankcharllenge.dtos.OperationResponseDTO;
import com.allo.bankcharllenge.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepositAccountMapper extends BaseMapper<Account, OperationResponseDTO> {
}
