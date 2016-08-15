package org.intellij.plugins.postcss;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.intellij.plugins.postcss.completion.PostCssCustomMediaCompletionTest;
import org.intellij.plugins.postcss.completion.PostCssCustomPropertiesSetCompletionTest;
import org.intellij.plugins.postcss.completion.PostCssCustomSelectorCompletionTest;
import org.intellij.plugins.postcss.completion.PostCssNestCompletionTest;
import org.intellij.plugins.postcss.fileStructure.PostCssFileStructureTest;
import org.intellij.plugins.postcss.inspections.*;
import org.intellij.plugins.postcss.lexer.PostCssLexerTest;
import org.intellij.plugins.postcss.lexer.highlighting.PostCssHighlightingLexerTest;
import org.intellij.plugins.postcss.parser.*;
import org.intellij.plugins.postcss.rename.PostCssRenameTest;
import org.intellij.plugins.postcss.resolve.PostCssCustomMediaResolveTest;
import org.intellij.plugins.postcss.resolve.PostCssCustomPorpertySetResolveTest;
import org.intellij.plugins.postcss.resolve.PostCssCustomSelectorResolveTest;
import org.intellij.plugins.postcss.smartEnter.PostCssSmartEnterTest;
import org.intellij.plugins.postcss.usages.PostCssFindUsagesTest;

@SuppressWarnings({"JUnitTestClassNamingConvention", "JUnitTestCaseWithNoTests"})
public class PostCssTestSuite extends TestCase {
  public static Test suite() {
    TestSuite testSuite = new TestSuite("All PostCSS");
    testSuite.addTest(WithoutPerformance.suite());
    return testSuite;
  }

  public static class WithoutPerformance extends TestCase {
    public static Test suite() {
      TestSuite suite = new TestSuite("All PostCSS without performance");
      suite.addTest(Fast.suite());
      suite.addTest(Inspections.suite());
      suite.addTest(Completion.suite());
      suite.addTest(Resolving.suite());
      suite.addTest(Refactoring.suite());
      suite.addTest(Other.suite());
      return suite;
    }
  }

  public static class Fast extends TestCase {
    public static Test suite() {
      TestSuite suite = new TestSuite("Fast PostCSS");
      suite.addTestSuite(PostCssLexerTest.class);
      suite.addTestSuite(PostCssParsingNestingTest.class);
      suite.addTestSuite(PostCssParsingCustomSelectorTest.class);
      suite.addTestSuite(PostCssParsingCustomMediaTest.class);
      suite.addTestSuite(PostCssParsingMediaRangesTest.class);
      suite.addTestSuite(PostCssParsingApplyTest.class);
      suite.addTestSuite(PostCssHighlightingLexerTest.class);
      return suite;
    }
  }

  public static class Inspections extends TestCase {
    public static Test suite() {
      TestSuite suite = new TestSuite("Inspections PostCSS");
      suite.addTestSuite(PostCssCssInspectionTest.class);
      suite.addTestSuite(PostCssNestingInspectionTest.class);
      suite.addTestSuite(PostCssCustomSelectorInspectionTest.class);
      suite.addTestSuite(PostCssNestingQuickFixTest.class);
      suite.addTestSuite(PostCssCustomSelectorQuickFixTest.class);
      suite.addTestSuite(PostCssMediaRangeInspectionTest.class);
      suite.addTestSuite(PostCssCustomMediaInspectionTest.class);
      suite.addTestSuite(PostCssCustomMediaQuickFixTest.class);
      suite.addTestSuite(PostCssCustomPropertiesSetInspectionTest.class);
      suite.addTestSuite(PostCssCustomPropertiesSetQuickFixTest.class);
      return suite;
    }
  }

  public static class Completion extends TestCase {
    public static Test suite() {
      TestSuite suite = new TestSuite("Completion PostCSS");
      suite.addTestSuite(PostCssNestCompletionTest.class);
      suite.addTestSuite(PostCssCustomSelectorCompletionTest.class);
      suite.addTestSuite(PostCssCustomMediaCompletionTest.class);
      suite.addTestSuite(PostCssCustomPropertiesSetCompletionTest.class);
      return suite;
    }
  }

  public static class Resolving extends TestCase {
    public static Test suite() {
      TestSuite suite = new TestSuite("Resolving PostCSS");
      suite.addTestSuite(PostCssCustomSelectorResolveTest.class);
      suite.addTestSuite(PostCssCustomMediaResolveTest.class);
      suite.addTestSuite(PostCssCustomPorpertySetResolveTest.class);
      suite.addTestSuite(PostCssFindUsagesTest.class);
      return suite;
    }
  }

  public static class Refactoring extends TestCase {
    public static Test suite() {
      TestSuite suite = new TestSuite("Refactoring PostCSS");
      suite.addTestSuite(PostCssRenameTest.class);
      return suite;
    }
  }

  public static class Other extends TestCase {
    public static Test suite() {
      TestSuite suite = new TestSuite("Other PostCSS");
      suite.addTestSuite(PostCssFileStructureTest.class);
      suite.addTestSuite(PostCssSmartEnterTest.class);
      return suite;
    }
  }
}