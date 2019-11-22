# TCMS-Logger

    <appender name="FILE"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_PATH}/log.log</file>
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <Pattern>
                %d{dd-MM-yyyy HH:mm:ss.SSS} [%thread] %-5level %logger{36}.%M - %msg%n
            </Pattern>
        </encoder>

        <!-- Comment out rolling policies to test how the remaining one works -->

        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- rollover daily -->
            <fileNamePattern>
                ${LOG_PATH}/archived/log.%d{dd-MM-yyyy}.log
            </fileNamePattern>
            <maxHistory>10</maxHistory>
            <totalSizeCap>100MB</totalSizeCap>
        </rollingPolicy>

        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!-- rollover daily & on size-->
            <maxFileSize>10MB</maxFileSize>
            <fileNamePattern>
                ${LOG_PATH}/archived/log_%d{dd-MM-yyyy}_%i.log
            </fileNamePattern>
            <maxHistory>10</maxHistory>
            <totalSizeCap>100MB</totalSizeCap>
        </rollingPolicy>

        <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
            <fileNamePattern>
                ${LOG_PATH}/log_%i.log
            </fileNamePattern>
            <minIndex>2</minIndex>
            <maxIndex>3</maxIndex>
        </rollingPolicy>

        <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <!-- rollover on size-->
            <maxFileSize>1KB</maxFileSize>
        </triggeringPolicy>

    </appender>