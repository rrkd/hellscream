<%@include file="../globe.jsp"%><html>
<div class="page-header">

    <h1>Apply Quote</h1>

    <div class="headerdivider">

    </div>

</div>

<div class="row-fluid top30">

    <div class="span6">
        <div class="titleborder">

            <div>

                Basic Information

            </div>

        </div>

        <form action="#">

            <input name="name" size="30" type="text" id="tradeName" class="span12" placeholder="TradeName" readonly value="${merchant.tradeName}">
            <input name="name" size="30" type="number" id="rawDay" class="span12" placeholder="rawDays">
            <input name="name" size="30" data-symbol="$" type="number" min="0.01" step="0.01" id="rawPrice" class="span12" placeholder="rawPrice">
            <select name="name" size="30" id="type_select"
                    class="populate placeholder select2-offscreen span12" style="margin-bottom: 10px; margin-left: 0;">
                <option value="Immediately">Immediately</option>
                <option value="Scheduled">Scheduled</option>
            </select>
            <textarea id="description" name="message" class="span12" placeholder="Description" rows="8"></textarea>
            <br/>
            <input name="name" size="30" type="hidden" id="keyString" class="span12"
                   value="${quote.keyString}">
            <input name="name" size="30" type="hidden" id="merchantKeyString" class="span12"
                   value="${merchant.keyString}">

            <input value="Apply" id="applyQuote" class="btn btn-primary top10">

        </form>

    </div>

    <div class="span6">


        <div class="titleborder">

            <div>

                Quote Details

            </div>

        </div>

        <div id="tagcloud" class="tagcloud" style="height: 100px">

            <!-- Accordions

           ================================================== -->
            <form action="#">
                <div class="accordion" id="accordion2">

                    <div class="accordion-group">

                        <div class="accordion-heading">

                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"
                               href="#collapseOne">

                                A </a>

                        </div>

                        <div id="collapseOne" class="accordion-body collapse" style="height: 0px;">

                            <div class="accordion-inner">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Accountants">Accountants
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Air Conditioning Experts">Air
                                        Conditioning Experts
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Alarm & Security Technicians">Alarm &
                                        Security
                                        Technicians<br/>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Antenna Specialists">Antenna
                                        Specialists<br/>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Appliance Installation & Repairers">Appliance
                                        Installation & Repairers<br/>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Architects & Residential Designers">Architects
                                        & Residential Designers<br/>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Asbestos Removalists">Asbestos
                                        Removalists<br/>
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="Awnings Experts">Awnings Experts<br/>
                                    </label>
                                </div>
                            </div>

                        </div>

                    </div>

                    <div class="accordion-group">

                        <div class="accordion-heading">

                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"
                               href="#collapseTwo">

                                B </a>

                        </div>

                        <div id="collapseTwo" class="accordion-body collapse" style="height: 0px;">

                            <div class="accordion-inner">

                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad
                                squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck
                                quinoa
                                nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid
                                single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft
                                beer labore wes anderson cred nesciunt sapiente.

                            </div>

                        </div>

                    </div>

                    <div class="accordion-group">

                        <div class="accordion-heading">

                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"
                               href="#collapseThree">

                                C </a>

                        </div>

                        <div id="collapseThree" class="accordion-body in collapse" style="height: auto;">

                            <div class="accordion-inner">

                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad
                                squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck
                                quinoa
                                nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid
                                single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft
                                beer labore wes anderson cred nesciunt sapiente.

                            </div>

                        </div>

                    </div>

                </div>

                <!-- END accordions -->
            </form>
        </div>
    </div>

</div>
<script type="text/javascript" src="/assets/js/quote/applyQuote.js"></script>