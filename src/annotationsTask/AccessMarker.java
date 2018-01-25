package annotationsTask;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited()
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
public @interface AccessMarker {
    Roles value() default Roles.DEFAULT;
}
