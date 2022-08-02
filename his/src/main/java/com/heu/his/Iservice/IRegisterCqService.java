package com.heu.his.Iservice;

import com.heu.his.pojo.Checkapply;
import com.heu.his.pojo.Drugs;
import com.heu.his.pojo.Fmeditem;
import com.heu.his.pojo.Register;
import org.apache.ibatis.annotations.Param;

/**
 * @author legend
 * @create 2022-07-31-10:10
 */
public interface IRegisterCqService {
    java.util.List<Register> selectByNameNumber(@Param("realName") String realName, @Param("caseNumber") String caseNumber);
    java.util.List<Drugs> selectDrugsByRegisterId(int id);
    java.util.List<Integer> selectDrugsAmountById(int id);
    java.util.List<Checkapply> selectCheckApplyByRegistId(int id);
    Fmeditem getFmeditemById(int id);

}
