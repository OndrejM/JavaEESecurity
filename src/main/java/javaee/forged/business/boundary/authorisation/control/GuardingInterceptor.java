package javaee.forged.business.boundary.authorisation.control;

import java.lang.reflect.Method;
import javaee.forged.business.boundary.authorisation.boundary.AllowAll;
import javaee.forged.business.boundary.authorisation.boundary.Guarded;
import javaee.forged.business.boundary.authorisation.boundary.Right;
import javaee.forged.business.boundary.authorisation.boundary.RightsAllowed;
import javaee.forged.business.boundary.authorisation.boundary.UserProvider;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Guarded
@Interceptor
public class GuardingInterceptor {
    
    @Inject
    UserProvider userProvider;
    
    @AroundInvoke
    public Object guard(InvocationContext ctx) throws Exception {
        if (check(ctx)) {
            return ctx.proceed();
        } else {
            throw new SecurityException();
        }
    }

    private boolean check(InvocationContext ctx) {
        RightsAllowed rights = ctx.getMethod().getAnnotation(RightsAllowed.class);
        boolean allowAll = ctx.getMethod().getAnnotation(AllowAll.class) != null;
        Boolean checkMethodAnnotationsResult = checkAnnotationValues(allowAll, rights);
        if (checkMethodAnnotationsResult != null) {
            return checkMethodAnnotationsResult;
        } else {
            rights = ctx.getTarget().getClass().getAnnotation(RightsAllowed.class);
            allowAll = ctx.getTarget().getClass().getAnnotation(AllowAll.class) != null;
            Boolean checkClassAnnotationResult = checkAnnotationValues(allowAll, rights);
            if (checkClassAnnotationResult != null) {
                return checkClassAnnotationResult;
            } else {
                // no annotations found, call is allowed
                return true;
            }
        }
    }

    private Boolean checkAnnotationValues(boolean allowAll, RightsAllowed rights) {
        if (allowAll) {
            return true;
        } else if (rights != null) {
            return checkHavingOneOfRights(rights.value());
        } else {
            return null;
        }
    }

    private boolean checkHavingOneOfRights(Right[] rights) {
        for (Right right : rights) {
            if (userProvider.currentÚserHasRight(right)) {
                return true;
            }
        }
        return false;
    }
}
