

package com.example.s19d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.s19d2.entity.Member;

/**
 * MemberRepository
 */
public interface MemberRepository extends JpaRepository<Member,Long>{

    
}