package org.evomaster.client.java.instrumentation.coverage.methodreplacement.classes;

import org.evomaster.client.java.instrumentation.coverage.methodreplacement.DateTimeParsingUtils;
import org.evomaster.client.java.instrumentation.coverage.methodreplacement.MethodReplacementClass;
import org.evomaster.client.java.instrumentation.coverage.methodreplacement.Replacement;
import org.evomaster.client.java.instrumentation.heuristic.Truthness;
import org.evomaster.client.java.instrumentation.heuristic.TruthnessUtils;
import org.evomaster.client.java.instrumentation.shared.ReplacementType;
import org.evomaster.client.java.instrumentation.shared.StringSpecialization;
import org.evomaster.client.java.instrumentation.shared.StringSpecializationInfo;
import org.evomaster.client.java.instrumentation.staticstate.ExecutionTracer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;


public class LocalTimeClassReplacement implements MethodReplacementClass {

    @Override
    public Class<?> getTargetClass() {
        return LocalTime.class;
    }

    /**
     * Parses a time without an offset, such as '10:15' or '10:15:30'.
     *
     * @param input
     * @param idTemplate
     * @return
     */
    @Replacement(type = ReplacementType.EXCEPTION, replacingStatic = true)
    public static LocalTime parse(CharSequence input, String idTemplate) {

        if (input != null && ExecutionTracer.isTaintInput(input.toString())) {
            ExecutionTracer.addStringSpecialization(input.toString(),
                    new StringSpecializationInfo(StringSpecialization.ISO_LOCAL_TIME, null));
        }

        if (idTemplate == null) {
            return LocalTime.parse(input);
        }

        try {
            LocalTime res = LocalTime.parse(input);
            ExecutionTracer.executedReplacedMethod(idTemplate, ReplacementType.EXCEPTION, new Truthness(1, 0));
            return res;
        } catch (DateTimeParseException | NullPointerException e) {
            double h = DateTimeParsingUtils.getDistanceToISOLocalTime(input);
            ExecutionTracer.executedReplacedMethod(idTemplate, ReplacementType.EXCEPTION, new Truthness(h, 1));
            throw e;
        }
    }


    @Replacement(type = ReplacementType.BOOLEAN)
    public static boolean equals(LocalTime caller, Object anObject, String idTemplate) {
        Objects.requireNonNull(caller);

        if (idTemplate == null) {
            return caller.equals(anObject);
        }

        final Truthness t;
        if (anObject == null || !(anObject instanceof LocalTime)) {
            t = new Truthness(0d, 1d);
        } else {
            final long a = caller.toSecondOfDay();
            final long b = ((LocalTime) anObject).toSecondOfDay();
            t = TruthnessUtils.getEqualityTruthness(a, b);
        }
        ExecutionTracer.executedReplacedMethod(idTemplate, ReplacementType.BOOLEAN, t);
        return caller.equals(anObject);
    }

    @Replacement(type = ReplacementType.BOOLEAN)
    public static boolean isBefore(LocalTime caller, LocalTime when, String idTemplate) {
        Objects.requireNonNull(caller);
        return LocalDateTimeClassReplacement.isBefore(
                toLocalDateTime(caller),
                when == null ? null : toLocalDateTime(when),
                idTemplate);

    }

    @Replacement(type = ReplacementType.BOOLEAN)
    public static boolean isAfter(LocalTime caller, LocalTime when, String idTemplate) {
        Objects.requireNonNull(caller);
        return LocalDateTimeClassReplacement.isAfter(
                toLocalDateTime(caller),
                when == null ? null : toLocalDateTime(when),
                idTemplate);
    }

    private static final LocalDate LOCAL_DATE = LocalDate.of(1970, 1, 1);

    private static LocalDateTime toLocalDateTime(LocalTime localTime) {
        Objects.requireNonNull(localTime);
        return localTime.atDate(LOCAL_DATE);
    }

}
