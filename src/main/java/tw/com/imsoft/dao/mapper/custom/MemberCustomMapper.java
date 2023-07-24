package tw.com.imsoft.dao.mapper.custom;

import tw.com.imsoft.dao.model.Member;

public interface MemberCustomMapper {
    
    Member getMemId(String lineId);
}