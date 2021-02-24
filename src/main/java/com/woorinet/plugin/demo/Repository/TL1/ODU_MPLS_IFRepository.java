//package com.woorinet.plugin.demo.Repository.TL1;
//
//import com.woorinet.plugin.demo.DTO.TL1.ODU_MPLS_IF;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface ODU_MPLS_IFRepository extends JpaRepository<ODU_MPLS_IF, String> {
//    @Query("SELECT o.MPLSIF_TYPE FROM ODU_MPLS_IF as o WHERE o.TID = :TID")
//    ODU_MPLS_IF findByTid (@Param("TID") String TID );
//}
