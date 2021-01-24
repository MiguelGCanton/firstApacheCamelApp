package com.example.demo.service.specifications;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import com.example.demo.model.Department;
import com.example.demo.model.Department_;

import org.springframework.data.jpa.domain.Specification;

public class DepartmentSpecification implements Specification<Department> {
 
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Department filter;
 
    public DepartmentSpecification(Department filter) {
        super();
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> cq,
            CriteriaBuilder cb) {
        Predicate equalPredicate = cb.conjunction();
        String pattern =  filter.getDeptname();
    
         equalPredicate = cb.equal(root.get(Department_.deptname).as(String.class), pattern);

        //Predicate equalPredicate2 = cb.equal(root.get("deptname"), filter.getDeptname());
        return equalPredicate;
        // Predicate p = cb.disjunction();
        // if (filter.getDeptname() != null) {
        //     try{
        //     p.getExpressions()
        //             .add(cb.like(root.get("deptname"), '%' + filter.getDeptname() + '%' ));
        //     } catch (Exception e){
                
        //     }
        // }

        // if (filter.getDept() != null && filter.getDept() != null) {
        //     p.getExpressions().add(
        //             cb.and(cb.equal(root.get("surname"), filter.getSurname()),
        //                     cb.equal(root.get("age"), filter.getAge())));
        // }
    }


//   public static Specification<Department> customerHasBirthday() {
//     return (root, query, cb) ->{ 
//     return cb.equal(root.get(Department_.deptname), today);
//     };
//      }
}


