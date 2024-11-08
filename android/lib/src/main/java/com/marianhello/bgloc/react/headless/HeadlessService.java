package com.marianhello.bgloc.react.headless;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;

import org.jetbrains.annotations.Nullable;

public class HeadlessService extends HeadlessJsTaskService {
    public final String TASK_KEY = "com.marianhello.bgloc.react.headless.Task";

    @Override
    protected @Nullable
    HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return new HeadlessJsTaskConfig(
                    TASK_KEY,
                    Arguments.fromBundle(extras),
                    60000, // timeout for the task
                    true // optional: defines whether or not  the task is allowed in foreground. Default is false
            );
        }
        return null;
    }
}
