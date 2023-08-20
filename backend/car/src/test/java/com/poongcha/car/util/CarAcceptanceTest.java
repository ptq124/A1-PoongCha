package com.poongcha.car.util;

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import util.DocumentationTest;

@TestExecutionListeners(listeners = DataInitializeExecutionListener.class, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
public class CarAcceptanceTest extends DocumentationTest {
}
