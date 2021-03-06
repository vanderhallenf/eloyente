/*
 * Copyright 2012 Technicolor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.technicolor.eloyente;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Item;
import hudson.model.Project;
import hudson.model.listeners.ItemListener;

@Extension
public final class JobListening extends ItemListener {

     /**
     * Used when a job is deleted.
     *
     * It will just call the stop for the job if it uses ElOyente.
     */
    @Override
    public void onDeleted(Item item) {
        System.out.println("Job " + item.getName() + " borrado\n");

        ElOyente instance = (ElOyente) ((AbstractProject) item).getTrigger(ElOyente.class);
        if (instance != null) {
            instance.stop();
        }
    }
}
