/*
 * Copyright 2012-2014 the original author or authors.
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

package com.github.jtail.sterren.jersey;

import com.github.jtail.testbeans.Chicken;
import com.github.jtail.testbeans.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Controller
@Slf4j
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Endpoint {

    @POST
    @Path("/validated")
    public Chicken validated(@Valid Chicken input) {
        log.info("Processing: " + input.toString());
        return input;
    }

    @POST
    @Path("/unvalidated")
    public Chicken unvalidated(Chicken input) {
        log.info("Processing: " + input.toString());
        return input;
    }

    @POST
    @Path("/foobar")
    public Foo foobar(@Valid Foo input) {
        log.info("Processing: " + input.toString());
        return input;
    }

}
