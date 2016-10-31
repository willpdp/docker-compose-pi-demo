package style_service;

import java.util.List;
import java.util.ArrayList;

public class CSS3Patterns {

    /*
    Patterns from: https://github.com/LeaVerou/css3patterns/

    -------------------------------------------------------------
    
    Copyright (c) 2011 Lea Verou, http://lea.verou.me/

    Permission is hereby granted, free of charge, to any person obtaining
    a copy of this software and associated documentation files (the
    "Software"), to deal in the Software without restriction, including
    without limitation the rights to use, copy, modify, merge, publish,
    distribute, sublicense, and/or sell copies of the Software, and to
    permit persons to whom the Software is furnished to do so, subject to
    the following conditions:

    The above copyright notice and this permission notice shall be
    included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
    EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
    MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
    NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
    LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
    OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
    WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
    */
		
    private static final List<String> patterns = new ArrayList<String>() {{
	    // foreground: #92baac, background: #e1ebbd
	    add("background: linear-gradient(45deg, FOREGROUND 45px, transparent 45px)64px 64px, linear-gradient(45deg, FOREGROUND 45px, transparent 45px, transparent 91px, BACKGROUND 91px, BACKGROUND 135px, transparent 135px), linear-gradient(-45deg, FOREGROUND 23px, transparent 23px, transparent 68px, FOREGROUND 68px, FOREGROUND 113px, transparent 113px, transparent 158px, FOREGROUND 158px);\n"+
		"background-color: BACKGROUND\n;"+
		"background-size: 128px 128px;\n");
	}};

    private CSS3Patterns() {

    }

    public static String aRandomCSS3Pattern() {
	return patterns.get(0);
    }

}
